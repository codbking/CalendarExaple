package com.utrust.customer.commom.presenter;

import com.utrust.customer.commom.base.RxPresenter;
import com.utrust.customer.commom.http.RetrofitHelper;
import com.utrust.customer.commom.presenter.contract.${name}Contract;

import javax.inject.Inject;

/**
 * Created by codbking on ${DATE}.
 */
public class ${name}Presenter extends RxPresenter<${name}Contract.View> implements ${name}Contract.Presenter {

    private RetrofitHelper mHelper;

    @Inject
    public ${name}Presenter(RetrofitHelper helper) {
        mHelper = helper;
    }

}
