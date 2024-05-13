package com.group.libraryapp.service.fruit;

import com.group.libraryapp.dto.fruit.request.FruitCreateRequest;
import com.group.libraryapp.dto.fruit.request.FruitUpdateRequest;
import com.group.libraryapp.dto.fruit.response.FruitStatResponse;
import com.group.libraryapp.repository.fruit.FruitJdbcRepository;
import org.springframework.stereotype.Service;

@Service
public class FruitService {

    private final FruitJdbcRepository fruitJdbcRepository;

    public FruitService(FruitJdbcRepository fruitJdbcRepository) {
        this.fruitJdbcRepository = fruitJdbcRepository;
    }

    public void saveFruit(FruitCreateRequest request) {
        fruitJdbcRepository.saveFruit(request.getName(), request.getWarehousingDate(), request.getPrice());
    }

    public void updateFruit(FruitUpdateRequest request) {
        if (fruitJdbcRepository.isUserNotExist(request.getId())) {
            throw new IllegalArgumentException();
        }

        fruitJdbcRepository.updateFruit(request.getId());
    }

    public FruitStatResponse statFruit(String name) {
        if (fruitJdbcRepository.isUserNotExist(name)) {
            throw new IllegalArgumentException();
        }

        return new FruitStatResponse(fruitJdbcRepository.salesAmount(name)
                                    , fruitJdbcRepository.notSalesAmount(name));
    }
}
