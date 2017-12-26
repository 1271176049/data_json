package com.sdp.edu.mapper;

import java.util.List;

import com.sdp.edu.bean.T_MALL_CLASS_1;
import com.sdp.edu.bean.T_MALL_CLASS_2;
import com.sdp.edu.bean.T_MALL_TRADE_MARK;

public interface Trade_markMapper {
	List<T_MALL_TRADE_MARK> select_trade_mark(int a);
}
