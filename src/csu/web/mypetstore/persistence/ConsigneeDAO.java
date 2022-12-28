package csu.web.mypetstore.persistence;

import csu.web.mypetstore.domain.Consignee;

import java.util.List;

public interface ConsigneeDAO {
    List<Consignee> getConsigneeByUsername(String username);
}
