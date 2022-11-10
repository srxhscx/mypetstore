package csu.web.mypetstore.persistence;

import csu.web.mypetstore.domain.Journal;

import java.sql.SQLException;

public interface JournalDAO {
     void write(Journal journal) throws SQLException;
}
