package me.calcifer.redistest.service;

import me.calcifer.redistest.entity.Invoice;
import me.calcifer.redistest.exception.InvoiceNotFoundException;
import me.calcifer.redistest.repo.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@CacheConfig(cacheNames = {"invoice"}, keyGenerator = "keyGenerator")
public class InvoiceService {
    private final InvoiceRepository invoiceRepository;

    public InvoiceService(InvoiceRepository invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }

    public Invoice insert(Invoice invoice) {
        return invoiceRepository.save(invoice);
    }

    public List<Invoice> getAll() {
        return invoiceRepository.findAll();
    }

    @Cacheable
    public Invoice getOne(Integer id) {
        return invoiceRepository.findById(id)
                .orElseThrow(() -> new InvoiceNotFoundException("Invoice Not Found"));
    }

    @CachePut
    public Invoice update(Invoice updatedInv, Integer id) {
        if (!invoiceRepository.existsById(id)) {
                throw new InvoiceNotFoundException("Invoice Not Found");
        }
        return invoiceRepository.save(updatedInv);
    }

    @CacheEvict
    // @CacheEvict(value="Invoice", allEntries=true) //in case there are multiple records to delete
    public void delete(Integer id) {
        Invoice invoice = invoiceRepository.findById(id)
                .orElseThrow(() -> new InvoiceNotFoundException("Invoice Not Found"));
        invoiceRepository.delete(invoice);
    }
}
