package dev.lxqtpr.linda.customerservice.services;

import dev.lxqtpr.linda.customerservice.dto.CreateCustomerDto;
import dev.lxqtpr.linda.customerservice.dto.ResponseCustomerDto;
import dev.lxqtpr.linda.customerservice.dto.UpdateCustomerDto;
import dev.lxqtpr.linda.customerservice.exceptions.ResourceNotFoundException;
import dev.lxqtpr.linda.customerservice.models.CustomerEntity;
import dev.lxqtpr.linda.customerservice.repositories.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final ModelMapper modelMapper;

    public ResponseCustomerDto createCustomer(CreateCustomerDto createCustomerDto) {
        var customerToSave = modelMapper.map(createCustomerDto, CustomerEntity.class);
        return modelMapper.map(customerRepository.save(customerToSave), ResponseCustomerDto.class);
    }

    public ResponseCustomerDto updateCustomer(UpdateCustomerDto updateCustomerDto) {
        customerRepository.findById(updateCustomerDto.getId())
                .orElseThrow(()-> new ResourceNotFoundException("Customer with this id does not exist"));
        var customerToUpdate = modelMapper.map(updateCustomerDto, CustomerEntity.class);
        return modelMapper.map(customerRepository.save(customerToUpdate), ResponseCustomerDto.class);
    }

    public List<ResponseCustomerDto> findAllCustomers() {
        var customers = customerRepository.findAll();

        return customers
                .stream()
                .map(el -> modelMapper.map(el, ResponseCustomerDto.class))
                .toList();
    }

    public ResponseCustomerDto findCustomerById(String customerId) {
        var customer = customerRepository.findById(customerId)
                .orElseThrow(()-> new ResourceNotFoundException("Customer with this id does not exist"));
        return modelMapper.map(customer, ResponseCustomerDto.class);

    }

    public void deleteCustomer(String customerId) {
        customerRepository.deleteById(customerId);
    }
}
