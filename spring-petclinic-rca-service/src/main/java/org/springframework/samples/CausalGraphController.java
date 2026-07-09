package org.springframework.samples;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.bean.FaultEdge;
import org.springframework.samples.bean.InputFault;
import org.springframework.samples.repository.FaultEdgeRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/causal")
@RestController
public class CausalGraphController {
    @Autowired
    private FaultEdgeRepository faultEdgeRepository;

    @GetMapping("/edges/all")
    public Iterable<FaultEdge> insertFault(InputFault inputFault) {
        Iterable<FaultEdge> edgeAll = faultEdgeRepository.findAll();
        return edgeAll;
    }
}
