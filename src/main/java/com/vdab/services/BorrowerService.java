package com.vdab.services;

import com.vdab.Repositories.BorrowerRepository;

import com.vdab.domain.Borrower;

public class BorrowerService {

    private BorrowerRepository borrowerRepository = new BorrowerRepository();

    public Borrower findFirstBorrower() {
        return borrowerRepository.findFirstBorrower();
    }
}
