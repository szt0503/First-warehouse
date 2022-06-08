package mapper;

import pojo.Provider;

import java.util.List;

public interface ProviderMapper {
    List<Provider> queryAll();
    Provider queryProAndBill(int id);

}
