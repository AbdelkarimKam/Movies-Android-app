package com.yassir.challenge.movies.tools

interface NetworkMapper<Network, DomaineModel> {
    fun mapFromNetwork(network: Network): DomaineModel
}