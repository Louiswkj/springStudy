package com.imooc.mall.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.imooc.mall.model.pojo.MallProduct;
import com.imooc.mall.model.dao.MallProductMapper;
import com.imooc.mall.service.MallProductService;

/**
 * @author liuliang
 * 2021/7/3
 */
@Service
public class MallProductServiceImpl extends ServiceImpl<MallProductMapper, MallProduct> implements MallProductService {

}


