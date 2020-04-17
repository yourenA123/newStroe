package com.helper.store.service;

import com.helper.store.domain.JsonMessage;

import java.util.List;
import java.util.Map;

/**
 * @author yanghao
 * @create 2019-08-08 15:32
 * @Description:
 */
public interface OrderService {

    /**
     * 生成订单
     * @param param
     * @return
     */
    JsonMessage saveOrder(Map<String,Object> param);



    /**
     * 取消订单
     * @param param
     * @return
     */
    JsonMessage cancelOrder(Map<String, Object> param);

    /**
     * 取消订单还原鞋子订单
     * @param param
     * @return
     */
    void restoreSell(Map<String,Object> param);

    /**
     * 生成订单鞋子卖出
     * @param param
     * @return
     */
    JsonMessage shoeSell(Map<String,Object> param);

    /**
     * 生成订单鞋子卖出2
     * @param param
     */
    JsonMessage shoeSell2(Map<String,Object> param);

    /**
     * 取消订单还原鞋子订单2
     * @param param
     */
    JsonMessage restoreSell2(Map<String,Object> param);

    /**
     * 立即付款
     * @param param
     * @return
     */
    JsonMessage payOrder(Map<String, Object> param);

    /**
     * 填写快递单号
     * @param param
     * @return
     */
    void inputTrackingNumber(Map<String,Object> param);

    /**
     * 获取快递单号
     * @param param
     * @return
     */
    Map<String,Object> getTrackingNumber(Map<String,Object> param);

    /**
     * 根据buysellID获取订单信息
     * @param param
     * @return
     */
    List<Map<String,Object>> getOrderByBuyorsellId(Map<String,Object> param);

    /**
     * 删除订单
     * @param param
     * @return
     */
    JsonMessage deleteOrder(Map<String, Object> param);

    /**
     * 获取订单号
     * @param param
     */
    void getOrderNo(Map<String,Object> param);

    /**
     * 完成订单
     * @param param
     * @return
     */
    void orderFinish(Map<String,Object> param);

    /**
     * 修改卖家余额
     * @param param
     */
    void sellUserBalance(Map<String,Object> param);

    /**
     * 修改买家余额
     * @param param
     */
    void buyUserBalance(Map<String,Object> param);

    /**
     * 生成买家余额明细
     * @param param
     * @return
     */
    void saveBuyUser(Map<String,Object> param);

    /**
     * 生成卖家余额明细
     * @param param
     * @return
     */
    void saveSellUser(Map<String,Object> param);

    /**
     * 保存通知
     * @param param
     */
    void saveNotice(Map<String,Object> param);

    /**
     * 查找通知
     * @param param
     */
    Map<String,Object> selectNoticeBuy(Map<String,Object> param);

    /**
     * 查找通知
     * @param param
     */
    Map<String,Object> selectNoticeSell(Map<String,Object> param);

    /**
     * 修改通知已读状态
     * @param param
     */
    void updateNotice(Map<String,Object>param);

    /**
     * 通过手机号查找用户
     * @param param
     */
    Map<String,Object> selectUserInfo(Map<String,Object>param);

    /**
     * 通过转移订单后的买家查找订单
     * @param param
     */
    List<Map<String,Object>> selectTransferbuy_user_id(Map<String,Object> param);

    /**
     * 修改转让订单价格
     * @param param
     */
    void updatePrice(Map<String,Object>param);

    /**
     * 转让订单
     * @param param
     */
    void updateOrderBuyUserId(Map<String,Object>param);

    /**
     * 取消订单还原价格
     * @param param
     */
    JsonMessage cancePrice(Map<String,Object>param);


    /**
     * 取消订单还原买家卖家和价格
     * @param param
     */
    JsonMessage canceOrderBuyUserId(Map<String,Object>param);

}
