package  com.mediTrack.controller;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import com.mediTrack.module.Prescription;
import com.mediTrack.service.PrescriptionService;
import java.util.List;

@RestController
@RequestMapping("/prescriptions")
@CrossOrigin(origins = "*")
public class PrescriptionController {

    private final PrescriptionService service;

    public PrescriptionController(PrescriptionService service){
        this.service = service;
    }

    @GetMapping
    public List<Prescription> getAll(){
        return service.getAllPrescription();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Prescription> getById(@PathVariable Long id){
        return ResponseEntity.ok(service.getPrescriptionById(id));
    }

    @PostMapping
    public ResponseEntity<Prescription> create(@Valid @RequestBody Prescription prescription) {
        return ResponseEntity.ok(service.addPrescription(prescription));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Prescription> update(@PathVariable Long id, @Valid @RequestBody Prescription prescription) {
        return ResponseEntity.ok(service.updatePrescription(id,prescription));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id){
        service.deletePrescriptionById(id);
        return ResponseEntity.ok("Prescription "+id+" deleted successfully");
    }

    @DeleteMapping
    public ResponseEntity<String> delete(){
        service.deleteAllPrescription();
        return ResponseEntity.ok("All Prescriptions deleted successfully");
    }


}