package com.ettakip.EtTakip.util;

public final class ApiPath {

    private static final String BASE_PATH = "/api";

    public static final class CustomerCtrl{

        public static final String CTRL = BASE_PATH + "/customer";
    }

    public static final class ProcessCtrl{
        public static final String CTRL = BASE_PATH + "/process";
    }

    public static final class SubProcessCtrl{
        public static final String CTRL = BASE_PATH + "/subprocess";
    }
}
