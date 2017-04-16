//package Dymanic;
//
//import com.yunyou.dal.dao.StrategyCollectionDao;
//import com.yunyou.dal.dao.StrategyDao;
//import com.yunyou.dal.entity.Strategy;
//import com.yunyou.dal.entity.StrategyCollection;
//import converter.StrategyConverter;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Sort;
//import org.springframework.stereotype.Service;
//
//import javax.annotation.Resource;
//import java.util.Collection;
//
///**
// * Created by Liujinglin on 17/3/18.
// */
//@Service
//public class UserStraregyService {
//    @Resource
//    private StrategyDao strategyDao;
//    @Resource
//    private StrategyCollectionDao strategyCollectionDao;
//    @Resource
//    private StrategyConverter strategyConverter;
//
//    // 发布一条攻略
//    public void publishStrategy(Strategy s) {
//        strategyDao.save(s);
//    }
//
//    // 按照返回分页返回所有内容
//    Page<Strategy> getAllStrategyByPaging(int pageNo, int pageSize) {
//        return strategyDao.findAll(new PageRequest(pageNo, pageSize, Sort.Direction.ASC, "id"));
//    }
//
//    // 按照返回分页关注的人发布的内容
//    Page<Strategy> getStrategyByIdsAndPaging(Collection<Long> ids, int pageNo, int pageSize) {
//        PageRequest pageRequest = new PageRequest(pageNo, pageSize, Sort.Direction.ASC, "id");
//        return strategyDao.findByPublishIdIn(ids, pageRequest);
//    }
//
//    // 收藏攻略
//    public void collectStrategy(Long strategyId) {
//        // TODO: 17/3/18 loginId
//        StrategyCollection strategyCollection = strategyCollectionDao.findByUserId(1L);
//        if (strategyCollection == null) {
//            StrategyCollection s = new StrategyCollection();
//            // TODO: 17/3/18 loginId
//            s.setUserId(1L);
//            s.setStrategyId(new StringBuilder(";").append(strategyId).append(";").toString());
//            strategyCollectionDao.save(s);
//            return;
//        }
//        // TODO: 17/3/18 loginId
//        strategyCollectionDao.updateById(
//            new StringBuilder(strategyCollection.getStrategyIds()).append(strategyId).append(";").toString(), 1L);
//    }
//
//    // 取消收藏
//    public void cancelCollectStrategy(Long strategyId) {
//        // TODO: 17/3/18 loginId
//        StrategyCollection s = strategyCollectionDao.findByUserId(1L);
//        if (s == null) {
//            return;
//        }
//        String tmp = s.getStrategyIds();
//        String target = new StringBuilder(";").append(strategyId).append(";").toString();
//        int pos = tmp.indexOf(target);
//        s.setStrategyId(
//            new StringBuilder(tmp.substring(0, pos)).append(tmp.substring(pos + target.length() + 1)).toString());
//        strategyCollectionDao.save(s);
//    }
//
//    public static void main(String[] args) {
//        String source = ";123;23;56;";
//        String target = new StringBuilder(";").append("123").append(";").toString();
//        int pos = source.indexOf(target);
//        System.out.println(
//            new StringBuilder(source.substring(0, pos)).append(source.substring(pos + target.length() - 1)).toString());
//    }
//}
