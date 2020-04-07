package com.xt.controller;

import com.xt.entity.FileList;
import com.xt.entity.FileListText;
import com.xt.service.FileListService;
import com.xt.service.FileListTextService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


/**
 * (FileList)表控制层
 *
 * @author makejava
 * @since 2020-02-15 16:55:53
 */
@RestController
@CrossOrigin
@RequestMapping("fileList")
public class FileListController {
    @Value("${web.upload-path}")
    private String uploadPath;
    /**
     * 服务对象
     */
    @Resource
    private FileListService fileListService;
    @Resource
    private FileListTextService fileListTextService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public FileList selectOne(Long id) {
        return this.fileListService.queryById(id);
    }

    /**
     * 输出收藏夹不空的文件List
     * */
//    @GetMapping("fileListWithCollectName")
    @RequestMapping(value = "fileListWithCollectName",method = RequestMethod.GET)
    public Map fileListWithCollectName(){
        return this.fileListService.queryFileWithCollectName();
    }

//    @GetMapping("queryFileList")
    @RequestMapping(value = "queryFileList",method = RequestMethod.GET)
    public Map queryFileList(){
        return this.fileListService.queryFileList();
    }

    /**
     * 根据文件id 删除文件
     */

    @ApiOperation(value = "根据文档id删除文档",notes = "注意事项....",httpMethod = "POST")
//    @ApiImplicitParam(dataType = "Long",name = "name123",value="value123",required = true)
    @RequestMapping(value = "deleteFileById",method = RequestMethod.POST)
    public Map deleteFileById(@RequestParam("id") Long id){
        Map result = new HashMap();
        String status = "0";
        String message = "删除成功";
        Boolean b = this.fileListService.deleteById(id);
        if(b==false){
            status = "1";
            message="删除失败";
        }
        result.put("status",status);
        result.put("message",message);

        return result;
    }




    /**
     * @auth: john Li
     * @param file
     * @param test
     * @return
     */


    @ApiOperation(value = "上传附件",notes = "注意事项....",httpMethod = "POST")
    @RequestMapping(value = "fileListUploadFiles",method = RequestMethod.POST)
    public Map fileListUploadFiles(@RequestBody MultipartFile file, String test, HttpServletRequest request) {
        System.out.println(test);
        Map resultMap = new HashMap();
        String status="0";
        String message="附件上传成功";
        resultMap.put("status",status);
        resultMap.put("message",message);
        if (file.isEmpty()) {
            status = "1";
            message="上传文件不能为空";
            resultMap.put("status",status);
            resultMap.put("message",message);
            return resultMap;
        }else{
            try {
                boolean uploadResult = this.fileListService.saveUplaodFile(file);
            } catch (IOException e) {
                status="2";
                message="附件上传失败.";
                resultMap.put("status",status);
                resultMap.put("message",message);
                e.printStackTrace();

            }

            //上传文件 相关逻辑
            String fileName = file.getOriginalFilename();
            String uploadFilePath = request.getSession().getServletContext().getRealPath("/");
            System.out.println(uploadFilePath);
//            try {
//                File dest = new File(uploadPath+fileName);
//                file.transferTo(dest);
//                HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
//                String username = request.getSession().getAttribute(Contant.USER_SESSION_KEY).toString();
//                return resultMap;
//            } catch (IOException e) {
//                status="2";
//                message="附件上传失败.";
//                resultMap.put("status",status);
//                resultMap.put("message",message);
//                e.printStackTrace();
//            }

            return resultMap;
        }
    }




    @ApiOperation(value = "上传附件",notes = "注意事项....",httpMethod = "POST")
//    @ApiImplicitParam(dataType = "Long",name = "name123",value="value123",required = true)
    @RequestMapping(value = "uploadFiles",method = RequestMethod.POST)
//    @PostMapping("uploadFiles")
//    附件&多参数传递,目前没解决---------------------
//    RequestParam 用来取axios 中param 的值,RequestBody 用来去axios中data 的值
//    FormData 传递过来的值,可以用RequestParam & RequestBody 来接收
//    public Map uploadFiles(@RequestParam("file") MultipartFile file,@RequestParam("saveCollectWithFileCons") String saveCollectWithFileCons) {
    public Map uploadFiles(@RequestBody MultipartFile file, String saveCollectWithFileCons) {
        System.out.println(saveCollectWithFileCons);
        Map resultMap = new HashMap();
        String status="0";
        String message="附件上传成功";
        resultMap.put("status",status);
        resultMap.put("message",message);
        if (file.isEmpty()) {
            status = "1";
            message="上传文件不能为空";
            resultMap.put("status",status);
            resultMap.put("message",message);
            return resultMap;
        }else{
        //上传文件 相关逻辑
            String fileName = file.getOriginalFilename();
            File dest = new File(uploadPath+fileName);
            try {
                file.transferTo(dest);
                return resultMap;
            } catch (IOException e) {
                status="2";
                message="附件上传失败.";
                resultMap.put("status",status);
                resultMap.put("message",message);
                e.printStackTrace();
            }

            return resultMap;
        }
    }


    @ApiOperation(value = "将附件添加到收藏夹",notes = "注意事项....",httpMethod = "POST")
//    @ApiImplicitParam(dataType = "Long",name = "name123",value="value123",required = true)
    @RequestMapping(value = "saveCollectWithFile",method = RequestMethod.POST)
    public Map saveCollectWithFile(@RequestBody Map<String,Object> map){
        Map result = new HashMap();
        String status = "0";
        String message = "文件添加成功";
        Long fileId = Long.parseLong(map.get("fileId").toString());
        Long collectId = Long.parseLong(map.get("collectNameListId").toString());
        FileList fileList = new FileList();
        fileList.setId(fileId);
        fileList.setCollectId(collectId);
        FileList f = this.fileListService.insert(fileList);
        if(f==null || f.equals(null)){
            status = "1";
            message="删除失败";
        }
        result.put("status",status);
        result.put("message",message);

        return result;
    }


    @ApiOperation(value = "更新文档备注信息", notes = "注意事项....", httpMethod = "POST")
//    @ApiImplicitParam(dataType = "Long",name = "name123",value="value123",required = true)
    @RequestMapping(value = "updateText", method = RequestMethod.POST)
    public Map updateText(@RequestBody Map map) {
        Map result = new HashMap();
        String status = "0";
        String message = "成功更新备注信息";
        Integer fileId = Integer.parseInt(map.get("fileId").toString());
        String text = map.get("text").toString();
        FileListText fileListText = new FileListText();
        fileListText.setFileListId(fileId);
        fileListText.setText(text);
        fileListText.setCreateDate(new Date());
        FileListText flt = fileListTextService.insert(fileListText);
        if(flt==null){
            status = "1";
            message = "更新备注信息失败";
        }
        return result;
    }





}