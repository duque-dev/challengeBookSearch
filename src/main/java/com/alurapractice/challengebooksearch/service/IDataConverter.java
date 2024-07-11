package com.alurapractice.challengebooksearch.service;

public interface IDataConverter {
    <T> T getData(String json, Class<T> clase);
}
