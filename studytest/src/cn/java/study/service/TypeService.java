package cn.java.study.service;

import java.util.ArrayList;
import java.util.List;

import cn.java.study.common.TreeUtile;
import cn.java.study.dao.DaoFactory;
import cn.java.study.dao.TypeDao;
import cn.java.study.domain.Node;
import cn.java.study.domain.Type;

public class TypeService {
	private TypeDao typedao= DaoFactory.getTypeDao();
	
	public List<Type> findAllType(){
		List<Type> typelist = typedao.findAllType();
		List<Type> tlist = new TreeUtile().data(typelist);
		
		return tlist;
	}

	public Object findByParentId(int parentid) {
		
		return typedao.findByParentId(parentid);
	}

	public List<Node> findAllNode() {
		List<Node> nodelst = new ArrayList<Node>();
		
		List<Type> typelist = typedao.findAllType();
		for (int i = 0; i < typelist.size(); i++) {
			Type type = typelist.get(i);
			Node node = new Node();
			node.setId(type.getTid());
			node.setpId(type.getParentid());
			node.setName(type.getTypename());
			nodelst.add(node);
		}
		return nodelst;
	}

	public List<Type> findAllType2() {
		return typedao.findAllType();
	}
}
