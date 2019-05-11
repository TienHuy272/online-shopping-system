package com.fa.mock.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.fa.mock.abstractdao.AbstractGenricDAOImpl;
import com.fa.mock.dao.ManufacturerDAO;
import com.fa.mock.model.Manufacturer;

@Repository("manufacturerDAO")
@Transactional
public class ManufacturerDAOImpl extends AbstractGenricDAOImpl<Manufacturer> implements ManufacturerDAO {

}
