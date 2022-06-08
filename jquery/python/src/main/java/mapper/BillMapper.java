package mapper;

import pojo.Bill;

import java.util.List;

public interface BillMapper {
    List<Bill> queryAll();

    Bill queryBillAndPro(int id);
}
