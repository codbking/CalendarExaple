package com.utrust.customer.commom.presenter.contract;

import com.utrust.customer.commom.base.BasePreseneter;
import com.utrust.customer.commom.base.BaseView;



#parse("File Header.java")
public interface ${NAME}Contract {

    interface View extends BaseView {
        void loading();
        void success(String data);
        void error(String message);
    }

    interface Presenter extends BasePreseneter<View> {
     void changePassword(String id, String account, String oldPassword, String newPasswor);
    }


}