//package Dymanic;
//
//import com.yunyou.dal.dao.DynamicDao;
//import com.yunyou.dal.entity.Dynamic;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Sort;
//import org.springframework.stereotype.Service;
//
//import javax.annotation.Resource;
//import java.util.Collection;
//
//
///**
// * Created by Liujinglin on 17/3/18.
// */
//@Service
//public class UserDynamicService {
//    @Resource
//    private DynamicDao dymanicDAO;
//
//    //发布一条动态
//    public void publshDynamic(Dynamic dynamic) {
//        dymanicDAO.save(dynamic);
//    }
//
//    public Page<Dynamic> getAllDynamicByPaging(int pageNo, int pageSize) {
//        return dymanicDAO.findAll(new PageRequest(pageNo, pageSize, Sort.Direction.ASC,"id"));
//    }
//
//    public Page<Dynamic> getDynamicByIdsAndPaging(Collection<Long> ids, int pageNo, int pageSize){
//        PageRequest pageRequest = new PageRequest(pageNo, pageSize, Sort.Direction.ASC,"id");
//        return dymanicDAO.findByPublishIdIn(ids, pageRequest);
//    }
//    public Collection<Dynamic> getDynamicByIds(Collection<Long> ids) {
//        return dymanicDAO.findByPublishIdIn(ids);
//    }
//    public void likeThisDynamic(Long dynamicId) {
//        dymanicDAO.likeThisDynamic(dynamicId);
//    }
//    // 转发动态
//    public void forwardDynamic(Long dynamicId) {
//        Dynamic dynamic = dymanicDAO.findById(dynamicId);
//        // TODO: 17/3/18  loginId
//        dynamic.setPublishId(1L);
//        dymanicDAO.save(dynamic);
//    }
//}
