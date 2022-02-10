package com.imooc.mall.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.imooc.mall.model.pojo.MallOrder;
import com.imooc.mall.model.dao.MallOrderMapper;
import com.imooc.mall.service.MallOrderService;

/**
 * @author liuliang
 * 2021/7/3
 */
@Service
public class MallOrderServiceImpl extends ServiceImpl<MallOrderMapper, MallOrder> implements MallOrderService {

}


