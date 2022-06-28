open module jmp.repository {
    requires jmp.model;
    requires jmp.dto;
    requires com.h2database;
    requires org.hibernate.orm.core;
    requires java.naming;
    requires java.sql;
    requires java.xml.bind;
    requires java.xml;
    exports jmp.repository.dao;
    requires com.fasterxml.classmate;
    requires java.persistence;
    requires net.bytebuddy;
    requires com.sun.xml.bind;
}