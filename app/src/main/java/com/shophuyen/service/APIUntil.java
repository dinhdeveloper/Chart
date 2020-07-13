package com.shophuyen.service;

public class APIUntil {
    //private static String baseURL = "https://mobishops.herokuapp.com/"; // https://mobishops.herokuapp.com/ http://vtnshop.herokuapp.com/
    private static String baseURL = "http://www.json-generator.com/api/"; // https://mobishops.herokuapp.com/ http://vtnshop.herokuapp.com/

    public static APIService getServer() {
        return APIClient.getApiClientLSP(baseURL).create(APIService.class);
    }
}
