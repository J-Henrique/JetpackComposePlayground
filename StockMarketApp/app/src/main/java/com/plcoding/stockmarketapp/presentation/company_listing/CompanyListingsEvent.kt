package com.plcoding.stockmarketapp.presentation.company_listing

sealed class CompanyListingsEvent {
    object OnRefresh: CompanyListingsEvent()
    data class OnSearchQueryChange(val query: String): CompanyListingsEvent()
}
