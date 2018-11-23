package com.taotao.service.impl;

import com.taotao.common.pojo.EUITreeNode;
import com.taotao.mapper.TbItemCatMapper;
import com.taotao.pojo.TbItemCat;
import com.taotao.pojo.TbItemCatExample;
import com.taotao.service.ItemCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemCatServiceImpl implements ItemCatService {

    @Autowired
    private TbItemCatMapper itemCatMapper;

    @Override
    public List<EUITreeNode> getCatList(long parentId) {
        TbItemCatExample example = new TbItemCatExample();
        TbItemCatExample.Criteria criteria = example.createCriteria();
        criteria.andParentIdEqualTo(parentId);

        List<TbItemCat> list = itemCatMapper.selectByExample(example);
        List<EUITreeNode> resultList = new ArrayList<>();
        for (TbItemCat tbItemCat : list){
            EUITreeNode node = new EUITreeNode();
            node.setId(tbItemCat.getId());
            node.setState(tbItemCat.getIsParent()?"closed":"open");
            node.setText(tbItemCat.getName());
            resultList.add(node);
        }
        return resultList;
    }
}
