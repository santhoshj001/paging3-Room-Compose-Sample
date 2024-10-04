package com.teamb.paging3roomsample.domain.usecase

abstract class BaseUseCase<in P, out R> {
    operator fun invoke(parameters: P): R = execute(parameters)
    protected abstract fun execute(parameters: P): R
}