package com.xz.fld.enums;

/**
 * 枚举类 
 *  列出所有模块和动作
 *  
 * @author zhanghairong
 * @since 2018-03-10
 */
public enum Module {

    /** 操作类型  **/
    OPER_TYPE_ADD(1,"新增"),
    OPER_TYPE_UPDATE(2,"修改"),
    OPER_TYPE_DELETE(3,"删除"),
    OPER_TYPE_SELECT(4,"查询"),
    OPER_TYPE_DETAIL(5,"详单"),
    OPER_TYPE_DOWNLOAD(6,"下载"),
    OPER_TYPE_UPLOAD(7,"上传"),
    
    /** 系统模块  **/
    SYS_MOUDLE_USER(1,"注册/登录"),
    SYS_MOUDLE_ROLE(2,"邀请"),
    SYS_MOUDLE_RESOURCE(3,"产品信息"),
    SYS_MOUDLE_PARAMETER(4,"查询");
    
    private Integer value; 
    private String name;
    
    Module(Integer value,String name){
        this.value = value;
        this.name = name;
    }
    
    public Integer getValue(){
        return value;
    }
    
    public String getName(){
        return name;
    }
    
    public static void main(String[] agrs){
        System.out.println(Module.valueOf("SYS_MOUDLE_TEMPLE").name);
    }
    
}
