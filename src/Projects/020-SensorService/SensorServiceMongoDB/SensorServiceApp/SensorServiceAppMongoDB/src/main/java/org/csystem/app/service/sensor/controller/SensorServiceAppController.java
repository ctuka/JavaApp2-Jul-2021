package org.csystem.app.service.sensor.controller;


import org.csystem.app.service.sensor.data.dto.SensorInfoDTO;
import org.csystem.app.service.sensor.service.SensorAppService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;

@RestController
@RequestMapping("api/sensors")
public class SensorServiceAppController {
    private final SensorAppService m_sensorAppService;

    public SensorServiceAppController(SensorAppService sensorAppService)
    {
        m_sensorAppService = sensorAppService;
    }

    @GetMapping("all")
    @RolesAllowed({"SYS_ADMIN", "SYS_USER"})
    public Iterable<SensorInfoDTO> findAll() //Burada tüm verilerin bu şekilde verilmesi uygun değildir. İleride düzelteceğiz
    {
        return m_sensorAppService.findAllSensors();
    }

    @GetMapping("sensor/greater")
    @RolesAllowed({"SYS_ADMIN", "SYS_USER"})
    public Iterable<SensorInfoDTO> findSensorsByGreater(@RequestParam("val") double value)
    {
        return m_sensorAppService.findSensorsByGreater(value);
    }

    @GetMapping("sensor/less")
    @RolesAllowed({"SYS_ADMIN", "SYS_USER"})
    public Iterable<SensorInfoDTO> findSensorsByLess(@RequestParam("val") double value)
    {
        return m_sensorAppService.findSensorsByLess(value);
    }

    @GetMapping("sensor")
    @RolesAllowed({"SYS_ADMIN", "SYS_USER"})
    public Iterable<SensorInfoDTO> findSensorsBetween(double min, double max)
    {
        return m_sensorAppService.findSensorsBetween(min, max);
    }
}
