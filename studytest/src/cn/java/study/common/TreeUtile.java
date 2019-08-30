package cn.java.study.common;

import java.util.ArrayList;
import java.util.List;

import cn.java.study.domain.Type;

public class TreeUtile {
	/**
	 * @Author 
	 * @Description //TODO 
	 * @Date 2018/10/31 0031 上午 12:02
	 * @Param nodes :所有的节点列表
	 * @return
	 */
	 public List<Type> data(List<Type> types) {
	        ArrayList<Type> rootType = new ArrayList<Type>();
	             for(Type type:types){
	                  if(type.getParentid()==0){
	                        rootType.add(type);
	                  }
	             }
	             for(Type type:rootType){
	                 List<Type> child = getChild(type.getTid(), types);
	                 type.setChildren(child);
	             }
	             return rootType;
	    }

	    /**
	     * @return
	     * @Author
	     * @Description //TODO 获取根节点的子节点
	     * @Date 2018/10/30 0030 下午 11:37
	     * @Param
	     */
	 public List<Type> getChild(int id, List<Type> allType) {
	        //存放子菜单的集合
	        ArrayList<Type> listChild = new ArrayList<Type>();
	        for (Type type : allType) {
	            if (type.getParentid()==id) {
	                listChild.add(type);
	            }
	        }
	        //递归：
	        for (Type type : listChild) {
	            type.setChildren(getChild(type.getTid(), allType));
	        }
	        if (listChild.size() == 0) {
	            return null;
	        }
	        return listChild;
	    }

}
