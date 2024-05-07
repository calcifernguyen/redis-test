package me.calcifer.redistest.controller;

import me.calcifer.redistest.entity.Invoice;
import me.calcifer.redistest.service.InvoiceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/invoice")
public class InvoiceController {
    InvoiceService invoiceService;

    public InvoiceController(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    @PostMapping("/")
    public ResponseEntity<Invoice> insert(@RequestBody Invoice invoice) {
        return ResponseEntity.status(HttpStatus.CREATED).body(invoiceService.insert(invoice));
    }

    @GetMapping("/")
    public ResponseEntity<List<Invoice>> getAll() {
        return ResponseEntity.ok(invoiceService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Invoice> getOne(@PathVariable Integer id) {
        return ResponseEntity.ok(invoiceService.getOne(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Invoice> update(@RequestBody Invoice invoice, @PathVariable Integer id) {
        return ResponseEntity.ok(invoiceService.update(invoice, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        invoiceService.delete(id);
        return ResponseEntity.noContent().build();
    }
}