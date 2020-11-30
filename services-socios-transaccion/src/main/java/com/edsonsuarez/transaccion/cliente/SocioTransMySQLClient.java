package com.edsonsuarez.transaccion.cliente;

import com.edsonsuarez.SocioHistorialDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("servicestransaccionmysql")
public interface SocioTransMySQLClient {

    @PostMapping("/registrohistorial")
    SocioHistorialDto registrar(@RequestBody SocioHistorialDto dto);
}