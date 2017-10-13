package com.xiaoming.util;

import java.util.ArrayList;

import com.esms.MessageData;
import com.esms.PostMsg;
import com.esms.common.entity.Account;
import com.esms.common.entity.GsmsResponse;
import com.esms.common.entity.MTPack;

public class SmsUtil {
	
	
	public static GsmsResponse sendMessage(PostMsg pm, Account ac, String phone, String content){
        MTPack pack = new MTPack();
        pack.setMsgType(MTPack.MsgType.SMS);
        pack.setBizType(1);
        pack.setDistinctFlag(false);
        pack.setSendType(MTPack.SendType.MASS);

        ArrayList<MessageData> msgs = new ArrayList<MessageData>();
        msgs.add(new MessageData(phone, content));
        pack.setMsgs(msgs);

        GsmsResponse resp = null;
        try {
            resp = pm.post(ac, pack);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resp;
    }
	  
	/**
	 *  # 玄武科技
		wxchina.mos.ip=211.147.239.62
		wxchina.mos.port=9080
		wxchina.mos.name=ycwl@ycwl
		wxchina.mos.password=MOSyecaixgkp00
	 * @return
	 */
	public static GsmsResponse sendMessage(String phone, String content){
        PostMsg pm = new PostMsg();
        pm.getCmHost().setHost("211.147.239.62", 9080);
        Account account = new Account("ycwl@ycwl", "MOSyecaixgkp00");
        return sendMessage(pm, account, phone, content);
    }
	
	public static void main(String[] args) {
		sendMessage("15914331441","fdsafads") ;
	}
	
	
}
