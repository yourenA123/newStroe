package com.helper.store.service.impl;

import com.helper.store.dao.OrderMapper;
import com.helper.store.domain.JsonMessage;
import com.helper.store.service.OrderService;
import com.helper.store.util.Constants;
import com.helper.store.util.ParamsUtils;
//import com.helper.store.websocket.WebSocketServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author yanghao
 * @create 2019-08-08 15:32
 * @Description:
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderMapper orderMapper;


    @Override
    public JsonMessage saveOrder(Map<String, Object> param) {
        JsonMessage jsonMessage = new JsonMessage();
        try {
            long orderNo = System.currentTimeMillis();
            param.put("orderNo",orderNo);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            param.put("createTime",sdf.format(new Date()));
            param.put("status",0);
            orderMapper.saveOrder(param);
            orderMapper.shoeSell(param);
            orderMapper.shoeSell2(param);
            orderMapper.saveBuyUser(param);
            orderMapper.saveSellUser(param);
            orderMapper.buyUserBalance(param);
            Map<String,Object> map = orderMapper.getOrderByNo(param);
            jsonMessage.setResponseCode(Constants.RES_CODE_0);
            jsonMessage.setErrorMessage(Constants.RES_MESSAGE_0);
            jsonMessage.setData(map);
        }catch (Exception e){
            e.printStackTrace();
            jsonMessage.setResponseCode(Constants.RES_CODE_101);
            jsonMessage.setErrorMessage(Constants.RES_MESSAGE_101);
        }
        return jsonMessage;

    }


    @Override
    public JsonMessage cancelOrder(Map<String, Object> param) {

        JsonMessage result = new JsonMessage();
        try {
            orderMapper.cancelOrder(param);
            orderMapper.restoreSell(param);
            orderMapper.restoreSell2(param);
            orderMapper.cancePrice(param);
            result.setResponseCode(Constants.RES_CODE_0);
            result.setErrorMessage(Constants.RES_MESSAGE_0);
        }catch (Exception e) {
            result.setResponseCode(Constants.RES_CODE_101);
            result.setErrorMessage(Constants.RES_MESSAGE_101);
        }
        return result;
    }

    @Override
    public void restoreSell(Map<String,Object> param){
       orderMapper.restoreSell(param);

    }

    @Override
    public JsonMessage shoeSell(Map<String, Object> param) {
        JsonMessage result = new JsonMessage();
        try {
            orderMapper.shoeSell(param);
            result.setResponseCode(Constants.RES_CODE_0);
            result.setErrorMessage(Constants.RES_MESSAGE_0);
        }catch (Exception e) {
            result.setResponseCode(Constants.RES_CODE_101);
            result.setErrorMessage(Constants.RES_MESSAGE_101);
        }
        return result;
    }

    @Override
    public JsonMessage shoeSell2(Map<String, Object> param) {
        JsonMessage result = new JsonMessage();
        try {
            orderMapper.shoeSell2(param);
            result.setResponseCode(Constants.RES_CODE_0);
            result.setErrorMessage(Constants.RES_MESSAGE_0);
        }catch (Exception e) {
            result.setResponseCode(Constants.RES_CODE_101);
            result.setErrorMessage(Constants.RES_MESSAGE_101);
        }
        return result;
    }

    @Override
    public JsonMessage restoreSell2(Map<String, Object> param) {
        JsonMessage result = new JsonMessage();
        try {
            orderMapper.restoreSell2(param);
            result.setResponseCode(Constants.RES_CODE_0);
            result.setErrorMessage(Constants.RES_MESSAGE_0);
        }catch (Exception e) {
            result.setResponseCode(Constants.RES_CODE_101);
            result.setErrorMessage(Constants.RES_MESSAGE_101);
        }
        return result;
    }

    @Override
    public JsonMessage payOrder(Map<String, Object> param) {
        JsonMessage result = new JsonMessage();
        try {
            orderMapper.payOrder(param);
            orderMapper.saveNotice(param);
            orderMapper.updatePrice(param);
            result.setResponseCode(Constants.RES_CODE_0);
            result.setErrorMessage(Constants.RES_MESSAGE_0);
        }catch (Exception e) {
            result.setResponseCode(Constants.RES_CODE_101);
            result.setErrorMessage(Constants.RES_MESSAGE_101);
        }
        return result;
    }

    @Override
    public void inputTrackingNumber(Map<String, Object> param) {
        ParamsUtils.getUser("userId",param);
        orderMapper.inputTrackingNumber(param);
    }

    @Override
    public Map<String, Object> getTrackingNumber(Map<String, Object> param) {
        return orderMapper.getTrackingNumber(param);
    }


    @Override
    public List<Map<String, Object>> getOrderByBuyorsellId(Map<String, Object> param) {
        ParamsUtils.getUser("userId",param);
        return orderMapper.getOrderByBuyorsellId(param);
    }


    @Override
    public JsonMessage deleteOrder(Map<String, Object> param) {
        JsonMessage result = new JsonMessage();
        try {
            orderMapper.deleteOrder(param);
            result.setResponseCode(Constants.RES_CODE_0);
            result.setErrorMessage(Constants.RES_MESSAGE_0);
        }catch (Exception e) {
            e.printStackTrace();
            result.setResponseCode(Constants.RES_CODE_101);
            result.setErrorMessage(Constants.RES_MESSAGE_101);
        }
        return result;
    }

    @Override
    public void getOrderNo(Map<String, Object> param) {
        return;

    }

    @Override
    public void orderFinish(Map<String, Object> param) {
        orderMapper.orderFinish(param);
        orderMapper.sellUserBalance(param);
    }

    @Override
    public void sellUserBalance(Map<String, Object> param) {
        orderMapper.sellUserBalance(param);
    }

    @Override
    public void buyUserBalance(Map<String, Object> param) {
        orderMapper.buyUserBalance(param);
    }

    @Override
    public void saveBuyUser(Map<String, Object> param) {
        orderMapper.saveBuyUser(param);
    }

    @Override
    public void saveSellUser(Map<String, Object> param) {
        orderMapper.saveSellUser(param);
    }

    @Override
    public void saveNotice(Map<String, Object> param) {
        orderMapper.saveNotice(param);
    }


    @Override
    public Map<String,Object> selectNoticeSell(Map<String, Object> param) {
       return orderMapper.selectNoticeSell(param);
    }

    @Override
    public void updateNotice(Map<String, Object> param) {
        orderMapper.updateNotice(param);
    }

    @Override
    public Map<String,Object> selectUserInfo(Map<String, Object> param) {

        return orderMapper.selectUserInfo(param);
    }

    @Override
    public List<Map<String, Object>> selectTransferbuy_user_id(Map<String, Object> param) {
        ParamsUtils.getUser("userId",param);
        return orderMapper.selectTransferbuy_user_id(param);
    }

    @Override
    public void updatePrice(Map<String, Object> param) {
        orderMapper.updatePrice(param);
    }

    @Override
    public void updateOrderBuyUserId(Map<String, Object> param) {
        orderMapper.updateOrderBuyUserId(param);
    }

    @Override
    public JsonMessage cancePrice(Map<String, Object> param) {
        JsonMessage result = new JsonMessage();
        try {
            orderMapper.cancePrice(param);
            result.setResponseCode(Constants.RES_CODE_0);
            result.setErrorMessage(Constants.RES_MESSAGE_0);
        }catch (Exception e) {
            result.setResponseCode(Constants.RES_CODE_101);
            result.setErrorMessage(Constants.RES_MESSAGE_101);
        }
        return result;
    }

    @Override
    public JsonMessage canceOrderBuyUserId(Map<String, Object> param) {
        JsonMessage result = new JsonMessage();
        try {
            orderMapper.canceOrderBuyUserId(param);
            result.setResponseCode(Constants.RES_CODE_0);
            result.setErrorMessage(Constants.RES_MESSAGE_0);
        }catch (Exception e) {
            result.setResponseCode(Constants.RES_CODE_101);
            result.setErrorMessage(Constants.RES_MESSAGE_101);
        }
        return result;
    }

    @Override
    public Map<String,Object> selectNoticeBuy(Map<String, Object> param) {
       return orderMapper.selectNoticeBuy(param);
    }


}
