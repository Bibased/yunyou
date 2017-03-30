package converter;

import com.google.common.base.Splitter;
import com.mysql.jdbc.StringUtils;
import com.yunyou.dal.dao.StrategyCollectionDao;
import com.yunyou.dal.entity.Strategy;
import com.yunyou.dal.entity.StrategyCollection;
import object.StrategyDO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Liujinglin on 17/3/19.
 */
@Service
public class StrategyConverter {
    @Resource
    private StrategyCollectionDao strategyCollectionDao;

    public StrategyDO covert(Strategy strategy) {
        StrategyDO strategyDO = new StrategyDO();
        strategyDO.setPublishId(strategy.getPublishId());
        strategyDO.setId(strategy.getId());
        strategyDO.setCityId(strategy.getCityId());
        strategyDO.setCityName(strategy.getCityName());
        strategyDO.setDays(strategy.getDays());
        strategyDO.setContent(strategy.getContent());
        strategyDO.setCoverUrl(strategy.getCoverUrl());
        strategyDO.setCreateTime(strategy.getCreateTime());
        strategyDO.setStartTime(strategy.getStartTime());
        strategyDO.setEndTime(strategy.getEndTime());
        strategyDO.setExpense(strategy.getExpense());
        strategyDO.setTitle(strategy.getTitle());
        // 是否已经收藏 TODO: 17/3/19
        StrategyCollection tmp = strategyCollectionDao.findByUserId(1L);
        if (tmp != null && StringUtils.isNullOrEmpty(tmp.getStrategyIds())) {
            List<String> result = Splitter.on(";").splitToList(tmp.getStrategyIds());
            strategyDO.setCollect(result.stream().anyMatch(elem -> elem.equals(strategy.getId())));
        }
        return strategyDO;
    }
}
