package com.xt.controller;

import com.alibaba.fastjson.JSON;
import com.xt.dao.FileListDao;
import com.xt.entity.CollectList;
import com.xt.entity.FileList;
import com.xt.service.CollectListService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * (CollectList)表控制层
 *
 * @author makejava
 * @since 2020-02-15 17:00:58
 */
@RestController
@CrossOrigin
@RequestMapping("collectList")
public class CollectListController {
    @Value("${web.upload-path}")
//    上传文件存储路径
    private String uploadPath;
    /**
     * 服务对象
     */
    @Resource
    private CollectListService collectListService;
    @Resource
    private FileListDao fileListDao;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public CollectList selectOne(Long id) {
        return this.collectListService.queryById(id);
    }

    /**
     * 获取全部收藏夹
     */
//    @GetMapping("queryAllCollect")
    @RequestMapping(value = "queryAllCollect", method = RequestMethod.GET)
    public List queryAllCollect() {
        return this.collectListService.queryAllCollect();
    }

    @ApiOperation(value = "根据收藏夹id删除收藏夹", notes = "注意事项....", httpMethod = "POST")
//    @ApiImplicitParam(dataType = "Long",name = "name123",value="value123",required = true)
    @RequestMapping(value = "deleteCollectById", method = RequestMethod.POST)
    public Map deleteCollectById(@RequestParam("id") Long id) {
        Map result = new HashMap();
        String status = "0";
        String message = "删除成功";
        Boolean b = this.collectListService.deleteById(id);
        if (b == false) {
            status = "1";
            message = "删除失败";
        }
        result.put("status", status);
        result.put("message", message);

        return result;
    }

    /**
     * 新建收藏夹
     */

    @ApiOperation(value = "根据收藏夹id删除收藏夹", notes = "注意事项....", httpMethod = "POST")
//    @ApiImplicitParam(dataType = "Long",name = "name123",value="value123",required = true)
    @RequestMapping(value = "saveGenerateCollectName", method = RequestMethod.POST)
    public Map saveGenerateCollectName(@RequestParam("collectList") String map) {
//    public Map saveGenerateCollectName(@RequestBody String map ){
//        String tempCollectList = map.get("collectList").toString();
        Map result = new HashMap();
        String status = "0";
        String message = "成功新建收藏夹";
        CollectList collectList = new CollectList();
        Map collectListMap = JSON.parseObject(map, Map.class);//map;//
        collectList.setCollectName(collectListMap.get("newCollectName").toString());
        String tempTime = collectListMap.get("newCollectNameDate").toString();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date dateTime = null;
        try {
            dateTime = simpleDateFormat.parse(tempTime);
        } catch (Exception e) {
            e.printStackTrace();
        }
        collectList.setGenerateDate(dateTime);
        collectList.setLastUpdateDate(dateTime);
        CollectList collectResult = this.collectListService.insert(collectList);
        if (collectResult == null) {
            status = "1";
            message = "新建收藏夹失败";
        }
        result.put("status", status);
        result.put("message", message);

        return result;
    }


    @ApiOperation(value = "根据收藏夹id重命名收藏夹", notes = "注意事项....", httpMethod = "POST")
//    @ApiImplicitParam(dataType = "Long",name = "name123",value="value123",required = true)
    @RequestMapping(value = "saveRenameCollectName", method = RequestMethod.POST)
    public Map saveRenameCollectName(@RequestBody Map map) {
//    public Map saveGenerateCollectName(@RequestBody String map ){
//        String tempCollectList = map.get("collectList").toString();
        Map result = new HashMap();
        String status = "0";
        String message = "重命名收藏夹成功";
        Long collectId = Long.parseLong(map.get("newCollectNameId").toString());
        String newCollectName = map.get("newCollectName").toString();

        CollectList collectList = new CollectList();
        collectList.setId(collectId);
        collectList.setCollectName(newCollectName);
        CollectList cl = this.collectListService.update(collectList);
        if (cl != null) {
            status = "1";
            message = "重命名收藏夹失败";
        }
        return result;
    }


    @ApiOperation(value = "上传附件", notes = "注意事项....", httpMethod = "POST")
//    @ApiImplicitParam(dataType = "Long",name = "name123",value="value123",required = true)
    @RequestMapping(value = "uploadCollectFile", method = RequestMethod.POST)
//    @PostMapping("uploadFiles")
//    附件&多参数传递,目前没解决---------------------
//    RequestParam 用来取axios 中param 的值,RequestBody 用来去axios中data 的值
//    FormData 传递过来的值,可以用RequestParam & RequestBody 来接收
//    public Map uploadCollectFile(@RequestParam("fileList") List<MultipartFile> fileList,@RequestParam("collectId") String collectId) {
    public Map uploadCollectFile(@RequestBody MultipartFile[] fileList, String collectId) {
        Map resultMap = new HashMap();
        String status = "0";
        String message = "附件上传成功";
        resultMap.put("status", status);
        resultMap.put("message", message);
        if (fileList.length == 0) {
            status = "1";
            message = "上传文件不能为空";
            resultMap.put("status", status);
            resultMap.put("message", message);
            return resultMap;
        } else {
            //上传文件 相关逻辑
            for (int i = 0; i < fileList.length; i++) {
                MultipartFile file = fileList[i];
                String fileName = file.getOriginalFilename();
                String fileCollectId = collectId;
                Date date = new Date();
                FileList fl = new FileList();
                fl.setCollectId(Long.parseLong(collectId));
                fl.setFileName(fileName);
                fl.setLastUpdateDate(new Date());
                fl.setUploadDate(new Date());
                File dest = new File(uploadPath + fileName);
                try {
                    fileListDao.insert(fl);
                    file.transferTo(dest);
                } catch (IOException e) {
                    status = "2";
                    message = "附件--  " + fileName + "  --上传失败.";
                    resultMap.put("status", status);
                    resultMap.put("message", message);
                    e.printStackTrace();
                    return resultMap;
                }
            }


            return resultMap;
        }
    }



}
