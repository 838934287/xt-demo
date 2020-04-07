package com.xt.service.impl;

import com.xt.dao.CollectListDao;
import com.xt.dao.FileListDao;
import com.xt.entity.CollectList;
import com.xt.entity.FileList;
import com.xt.service.FileListService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * (FileList)表服务实现类
 *
 * @author makejava
 * @since 2020-02-15 16:55:52
 */
@Service("fileListService")
public class FileListServiceImpl implements FileListService {
    @Value("${web.upload-path}")
    private String uploadPath;

    @Resource
    private FileListDao fileListDao;

    @Resource
    private CollectListDao collectListDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public FileList queryById(Long id) {
        return this.fileListDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<FileList> queryAllByLimit(int offset, int limit) {
        return this.fileListDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param fileList 实例对象
     * @return 实例对象
     */
    @Override
    public FileList insert(FileList fileList) {

        this.fileListDao.insert(fileList);
        return fileList;
    }

    /**
     * 修改数据
     *
     * @param fileList 实例对象
     * @return 实例对象
     */
    @Override
    public FileList update(FileList fileList) {
        this.fileListDao.update(fileList);
        return this.queryById(fileList.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.fileListDao.deleteById(id) > 0;
    }

    /*
    * 查询现有收藏夹下的文件
    *
    *
    * */
    @Override
    public Map queryFileWithCollectName(){
        List outList = new ArrayList();
        List outList1 = new ArrayList();

        List f_list = fileListDao.queryFileWithCollectName();
        List<CollectList> c_list = collectListDao.queryAll(null);

//        获取fileList 中全部收藏夹
        List list1 = new ArrayList();
        for(int i =0;i<f_list.size();i++){
            Map m = new HashMap();
            m =(Map) f_list.get(i);
            if(!list1.contains(m.get("collectId"))){
                list1.add(m.get("collectId"));
            }
        }

        List headList = new ArrayList();
        Map totalHeadMap = new HashMap();
        for(int i =0;i<list1.size();i++){
            Map headMap = new HashMap();
            List lineList = new ArrayList();
            for(int j=0;j<f_list.size();j++){
                Map lineMap = new HashMap();
                Map m = new HashMap();
                m = (Map)f_list.get(j);
                String fCollectId = m.get("collectId").toString();
                if(list1.get(i).toString().equals(fCollectId) ){

                    headMap.put("generateDate",m.get("generateDate"));
                    headMap.put("collectName",m.get("collectName"));
                    headMap.put("lastUpdateDate",m.get("lastUpdateDate"));
                    headMap.put("generateUser",m.get("generateUser"));
                    headMap.put("headId",m.get("collectId"));

                    if(m.get("fileName").toString().length()==0 || m.get("fileName") == null){
                        continue;
                    }

                    lineMap.put("lineId",m.get("fileListId"));
                    lineMap.put("headId",m.get("collectId")+"-"+m.get("fileListId"));
                    lineMap.put("fileName",m.get("fileName"));
                    lineMap.put("uploadDate",m.get("uploadDate"));
                    lineMap.put("uploadUser",m.get("uploadUser"));
                    lineMap.put("lastUpdateDate",m.get("lastUpdateDate"));
                    lineMap.put("lastUpdateUser",m.get("lastUpdateUser"));
                    lineList.add(lineMap);
                }
                if(j==f_list.size()-1){
                    headMap.put("children",lineList);
                }
            }
            headList.add(headMap);

        }
        totalHeadMap.put("collectListData",headList);

        return totalHeadMap;

    };
    /*
    * 查询file List
    * */

    @Override
    public Map queryFileList() {
        List outList = new ArrayList() ;
        FileList fileList = new FileList();
        List list = fileListDao.queryAllAddCollectByLimit();

        Map outMap = new HashMap();
        for(int i=0;i<list.size();i++){
            Map lineMap = new HashMap();
            Map map =(Map) list.get(i);
            lineMap.put("id",map.get("id"));
            lineMap.put("lineId",map.get("id"));
            lineMap.put("headId",map.get("collectId"));
            lineMap.put("uploadUser",map.get("uploadUser"));
            lineMap.put("fileName",map.get("fileName"));
            lineMap.put("collectName",map.get("collectName"));
            lineMap.put("uploadDate",map.get("uploadDate"));
            lineMap.put("lastUpdateDate",map.get("lastUpdateDate"));
            outList.add(lineMap);
        }
        outMap.put("fileListData",outList);
        return outMap;
    }

    @Override
    public boolean saveUplaodFile(MultipartFile file)  {
        boolean b = true;
        InputStream ins = null;
        try{
        ins = file.getInputStream();
        String fileName = file.getOriginalFilename();
        File dest = new File(uploadPath+fileName);
        if(!dest.getParentFile().exists()){
            dest.getParentFile().mkdir();
        }
        if(!dest.exists()){
            try {
                dest.createNewFile();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        inputStreamToFile(ins, dest);
        ins.close();
        }catch (IOException e) {
            e.printStackTrace();
            b=false;
        }

        return b;
    }


    //获取流文件
    private static void inputStreamToFile(InputStream ins, File file) {
        try {
            OutputStream os = new FileOutputStream(file);
            int bytesRead = 0;
            byte[] buffer = new byte[8192];
            while ((bytesRead = ins.read(buffer, 0, 8192)) != -1) {
                os.write(buffer, 0, bytesRead);
            }
            os.close();
            ins.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }





}