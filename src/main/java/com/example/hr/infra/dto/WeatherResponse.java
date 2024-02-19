package com.example.hr.infra.dto;

import com.example.hr.dto.openapi.OpenApiDataResponse;

import java.util.List;

public record WeatherResponse(DataResponse response) {

    public record DataResponse(HeaderResponse header, BodyResponse body){

    }

    public record HeaderResponse (String resultCode, String resultMsg){

    }
    public record BodyResponse (String dateType, ItemResponse items, int pageNo, int numOfRows, int totalCount){

    }

    public record ItemResponse(List<StringResponse> item){

    }
    public record StringResponse(String wfSv){}

    public OpenApiDataResponse convertResponse(){
        return new OpenApiDataResponse(response.header.resultCode, response.header.resultMsg,
                response.body.pageNo, response.body.numOfRows, response.body.totalCount,
                response.body.items.item.get(0).wfSv);
    }

    public OpenApiDataResponse convertFailedResponse(){
        return new OpenApiDataResponse(response.header.resultCode, response.header.resultMsg,
                0, 0, 0, null);
    }
}
