package mapper;
import pojo.Address;
import java.util.List;
public interface AddressMapper {
    List<Address> queryAll();
    // 为实现从Address 端查询用户信息的功能，显示编写该方法
    Address queryAddressAndUser(int id);
}

