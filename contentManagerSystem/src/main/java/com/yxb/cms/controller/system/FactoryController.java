package com.yxb.cms.controller.system;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yxb.cms.architect.annotation.SystemControllerLog;
import com.yxb.cms.architect.constant.BussinessCode;
import com.yxb.cms.architect.utils.BussinessMsgUtil;
import com.yxb.cms.controller.BasicController;
import com.yxb.cms.domain.bo.BussinessMsg;
import com.yxb.cms.domain.vo.Factory;
import com.yxb.cms.service.FactoryService;

/**
 * @ClassName:  FactoryController   
 * @Description:TODO(工厂管理控制)   
 * @author: zhangxy
 * @date:   2020年2月25日 下午3:29:32   
 *
 */
@Controller
@RequestMapping("factory")
public class FactoryController extends BasicController{
	@Autowired
    private FactoryService factoryService;
	/**
     *跳转到工厂列表页面
     * @return
     */
    @RequestMapping("/factory_list.do")
    public String tofactoryListPage() {
        return "system/factory_list";
    }
    /**
     * 加载资源列表List
     * @param resource
     * @return
     */
    @RequestMapping("/ajax_factory_list.do")
    @ResponseBody
    public String ajaxFactoryList(Factory factory){
        return factoryService.selectFactoryResultPageList(factory);
    }
    /**
     * 跳转到工厂新增页面
     * @return
     */
    @RequestMapping("/factory_add.do")
    public String toFactoryAddPage(Model model) {
        //新增页面标识
        model.addAttribute("pageFlag", "addPage");
        return "system/factory_edit";
    }

    /**
     * 跳转到工厂修改页面
     * @param id 工厂id
     * @return
     */
    @RequestMapping("/factory_update.do")
    public String factoryUpdatePage(Model model,Integer id){
    	Factory factory = factoryService.selectByPrimaryKey(id);
        //修改页面标识
        model.addAttribute("pageFlag", "updatePage");
        model.addAttribute("factory", factory);
        return "system/factory_edit";
    }
    /**
     * 保存工厂信息
     * @param Factory 工厂实体
     * @return
     */
    @RequestMapping("/ajax_save_factory.do")
    @ResponseBody
    @SystemControllerLog(description="保存工厂信息")
    public BussinessMsg ajaxSaveFactory(Factory factory){
        try {
            return factoryService.saveOrUpdateFactory(factory, this.getCurrentLoginName());
        } catch (Exception e) {
            log.error("保存工厂信息方法内部错误",e);
            return BussinessMsgUtil.returnCodeMessage(BussinessCode.USER_SAVE_ERROR);
        }
    }
}
