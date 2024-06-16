package com.example.econom_main.Product.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.net.ConnectException;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Object> handleIllegalArgumentException(IllegalArgumentException ex){
        return new ResponseEntity<>("Передан некорректный параметр", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(CategoryNotFoundException.class)
    public ResponseEntity<Object> handleCategoryNotFoundException(CategoryNotFoundException ex){
        return new ResponseEntity<>("Категории с таким id не существует", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<Object> handleProductNotFoundException(CategoryNotFoundException ex){
        return new ResponseEntity<>("Продукта с таким id не существует", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ConnectException.class)
    public ResponseEntity<Object> handleConnectException(ConnectException ex){
        return new ResponseEntity<>("Неудачное соединение со SbermarketAPI", HttpStatus.BAD_GATEWAY);
    }

    @ExceptionHandler(InvalidTokenException.class)
    public ResponseEntity<Object> handleInvalidTokenException(InvalidTokenException ex){
        return new ResponseEntity<>("Не существует корзины с таким токеном", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InvalidShopNameException.class)
    public ResponseEntity<Object> handleInvalidShopNameException(InvalidShopNameException ex){
        return new ResponseEntity<>("Товара нет в магазине с таким названием", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ProductNotFoundInCartException.class)
    public ResponseEntity<Object> handleProductNotFoundInCartException(ProductNotFoundInCartException ex){
        return new ResponseEntity<>("В корзине нет такого товара, который Вы пытаетесь удалить", HttpStatus.BAD_REQUEST);
    }
}
