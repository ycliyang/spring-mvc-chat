package com.ly.web.controller;

import com.ly.web.db.entity.AppInfoEntity;
import com.ly.web.model.ResultModel;
import com.ly.web.service.RunAppsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;

/**
 * Created by liyang on 15/3/28.
 */
@Controller
@RequestMapping("/runApps")
public class RunAppsController {

    @Resource(name = RunAppsService.TAG_NAME)
    public RunAppsService runAppsService;

    @RequestMapping(value = "/message", method = RequestMethod.GET)
    @ResponseBody
    public ResultModel messageController() {

        ResultModel resultModel = new ResultModel();
        resultModel.setData(runAppsService.getRunsInfoModel());
        return resultModel;
    }


    /**
     * 上传APP信息
     *
     * @param packageName
     * @param versionCode
     * @param appName
     * @param versionNumber
     * @param status
     * @return
     */
    @RequestMapping(value = "/appInfo", method = RequestMethod.POST)
    @ResponseBody
    public ResultModel appInfoController(@RequestParam String packageName,
                                         @RequestParam String versionCode,
                                         @RequestParam String appName,
                                         @RequestParam String versionNumber,
                                         @RequestParam int status) {
        ResultModel resultModel = new ResultModel();

        AppInfoEntity appInfoEntity = new AppInfoEntity();
        appInfoEntity.setAppName(appName);
        appInfoEntity.setVersionCode(versionCode);
        appInfoEntity.setPackageName(packageName);
        appInfoEntity.setStatus(status);
        appInfoEntity.setVersionNumber(versionNumber);
        runAppsService.createAppInfoService(appInfoEntity);
        return resultModel;
    }


    @RequestMapping(value = "/white", method = RequestMethod.GET)
    @ResponseBody
    public ResultModel appInfoWhiteController() {
        ResultModel resultModel = new ResultModel();

        resultModel.setData(runAppsService.getAppInfoWhiteService());
        return resultModel;
    }

    @RequestMapping(value = "/black", method = RequestMethod.GET)
    @ResponseBody
    public ResultModel appInfoBlackController() {
        ResultModel resultModel = new ResultModel();

        resultModel.setData(runAppsService.getAppInfoBlackService());
        return resultModel;
    }

    @RequestMapping(value = "/normal", method = RequestMethod.GET)
    @ResponseBody
    public ResultModel appInfoNormalController() {
        ResultModel resultModel = new ResultModel();

        resultModel.setData(runAppsService.getAppInfoNormalService());
        return resultModel;
    }


    @RequestMapping(value = "/uploadAPK", method = RequestMethod.PUT)
    @ResponseBody
    public ResultModel uploadAPKController(MultipartFile fileAPK, HttpServletRequest request) {
        ResultModel resultModel = new ResultModel();
        String path = request.getSession().getServletContext().getRealPath("upload");
        File targetFile = new File("../../userFile/" + System.currentTimeMillis() + ".apk");
        if (!targetFile.exists()) {
            targetFile.mkdirs();
        }

        //保存
        try {
            fileAPK.transferTo(targetFile);
            resultModel.setData(targetFile.getAbsolutePath());
        } catch (Exception e) {
            e.printStackTrace();
            resultModel.setCode(ResultModel.Code.success);
        }
//        model.addAttribute("fileUrl", request.getContextPath()+"/upload/"+fileName);

        return resultModel;
    }

}
