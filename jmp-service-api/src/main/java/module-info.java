module jmp.service.api {
    requires jmp.dto;
    requires jmp.repository;
    exports jmp.service.api;
    uses jmp.service.api.Service;
}