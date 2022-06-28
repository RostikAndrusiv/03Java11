module jmp.cloud.service.impl {
    requires jmp.dto;
    requires transitive jmp.service.api;
    exports jmp.cloud.service.impl;
    exports jmp.cloud.service.impl.exception;
    requires repository;
    requires jmp.repository;
    requires jmp.model;
    requires jmp.util;
    provides jmp.service.api.Service with jmp.cloud.service.impl.ServiceImpl;
}