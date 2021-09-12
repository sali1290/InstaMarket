package com.e.data.repository

import android.app.Activity
import android.content.Context
import android.widget.Toast
import com.e.data.api.GetTransactionConverter
import com.e.data.api.TransactionRequest
import com.e.data.mapper.TransactionMapper
import com.e.data.repository.transactionDataSource.remote.TransactionRemoteDataSource
import com.e.data.utile.NetWorkHelper
import com.e.data.utile.SessionManager
import com.e.domain.models.TransactionModel
import com.e.domain.repository.TransactionRepo
import java.io.IOException
import javax.inject.Inject

class TransactionRepoImpl @Inject constructor(
    private val transactionRemoteDataSource: TransactionRemoteDataSource,
    private val netWorkHelper: NetWorkHelper,
    private val transactionMapper: dagger.Lazy<TransactionMapper>,
    private val sessionManager: SessionManager
) : TransactionRepo {

    @Throws(IOException::class)
    override suspend fun createTransaction(amount: String, type: String): String {
        lateinit var message: String
        if (netWorkHelper.isNetworkConnected()) {
            if (transactionRemoteDataSource.createTransactionFromRemote(
                    amount,
                    type
                ).isSuccessful &&
                transactionRemoteDataSource.createTransactionFromRemote(amount, type).body() != null
            ) {
                message =
                    transactionRemoteDataSource.createTransactionFromRemote(amount, type).body()
                        .toString()
                return message
            } else {
                throw IOException("Server is Not Responding")
            }
        } else {
            throw IOException("No Internet Connection")
        }
    }

    @Throws(IOException::class)
    override suspend fun getTransactions(id: String): MutableList<TransactionModel> {
        lateinit var transactions: MutableList<TransactionModel>
        val accessToken: String = sessionManager.fetchAuthToken()!!
        val transactionRequest: TransactionRequest = GetTransactionConverter().converter("12")
        if (netWorkHelper.isNetworkConnected()) {
            if (transactionRemoteDataSource.getUserTransactionFromRemote(
                    "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJhdWQiOiIxIiwianRpIjoiOTE3NTYyYzVhN2Q3YzIxYzVhNTgzMTlmMmNhZDA2YzMzYzlhYTZlMmJmMjI0MGI4ODRiNGIwZjdmODUxZGQ1MzQzMzU1YzYyNzYwMDc0MGYiLCJpYXQiOjE2Mjk0ODA4MzgsIm5iZiI6MTYyOTQ4MDgzOCwiZXhwIjoxNjQ1Mzc4NDM4LCJzdWIiOiIyNTYiLCJzY29wZXMiOltdfQ.NcXOPRDEb5Fli2y66V70AOkkmfJZ-DPjsChYW6PopFycl3WDNXvtO62CMjNHDjoUL-RpD7gxBX56U43-89npxVmhkP7bgtGE38HMAk2kawu8eFgKTLQv7XHPUv3xof2ibQ5Usjkmq2l7g5KYZgvYm08MRiRw2JT5EH1oiWwuMiZpBlCf4DBaE5gcdAxA8fh5fg83DGw2Bl3j3xbMjZ8vQiEQXjdPf-ECPcNVuaQgszn94qdAQvS805jUOFGeEzr8_87H7iZvnJ17VhONcL7Ar7N3D1VeOI5rbYLDfets_TKzU0U8tz4ZT3DdEN66pyZ234lkqRZOOeggy61KpCoI3f78vCdnbN7ZQUwE82nn_Rshh_2UdGYHKT_AIX0BTkedGjOFb03HV2UTp2sClaaoR5xr0TypJf1fNOz9-tYgZolerIy0gctvTZYhqsUxs2K-OqeAYzQBQpwKJrT78pc3mW9W9SicTtV9j-kHsHUFImv4ca_AK_yjAyqu81xCgKxFZN1ZvcKIjhtLI5OAqwz-PwtQKPRfr8X3C16NR1d82FohtsSIw1fRfQNsWT4P7Xgs8FhSE-vGSStmnzFwehJcksEo0akfIkkB1YwXOo7b7S3lWgkYbVGa0zSr_lST-FHYElQAD82EB2L04QLwBqlgBP-eK4ZKrbcWU52QL4Fe-90",
                    transactionRequest
                ).isSuccessful &&
                transactionRemoteDataSource.getUserTransactionFromRemote(
                    "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJhdWQiOiIxIiwianRpIjoiOTE3NTYyYzVhN2Q3YzIxYzVhNTgzMTlmMmNhZDA2YzMzYzlhYTZlMmJmMjI0MGI4ODRiNGIwZjdmODUxZGQ1MzQzMzU1YzYyNzYwMDc0MGYiLCJpYXQiOjE2Mjk0ODA4MzgsIm5iZiI6MTYyOTQ4MDgzOCwiZXhwIjoxNjQ1Mzc4NDM4LCJzdWIiOiIyNTYiLCJzY29wZXMiOltdfQ.NcXOPRDEb5Fli2y66V70AOkkmfJZ-DPjsChYW6PopFycl3WDNXvtO62CMjNHDjoUL-RpD7gxBX56U43-89npxVmhkP7bgtGE38HMAk2kawu8eFgKTLQv7XHPUv3xof2ibQ5Usjkmq2l7g5KYZgvYm08MRiRw2JT5EH1oiWwuMiZpBlCf4DBaE5gcdAxA8fh5fg83DGw2Bl3j3xbMjZ8vQiEQXjdPf-ECPcNVuaQgszn94qdAQvS805jUOFGeEzr8_87H7iZvnJ17VhONcL7Ar7N3D1VeOI5rbYLDfets_TKzU0U8tz4ZT3DdEN66pyZ234lkqRZOOeggy61KpCoI3f78vCdnbN7ZQUwE82nn_Rshh_2UdGYHKT_AIX0BTkedGjOFb03HV2UTp2sClaaoR5xr0TypJf1fNOz9-tYgZolerIy0gctvTZYhqsUxs2K-OqeAYzQBQpwKJrT78pc3mW9W9SicTtV9j-kHsHUFImv4ca_AK_yjAyqu81xCgKxFZN1ZvcKIjhtLI5OAqwz-PwtQKPRfr8X3C16NR1d82FohtsSIw1fRfQNsWT4P7Xgs8FhSE-vGSStmnzFwehJcksEo0akfIkkB1YwXOo7b7S3lWgkYbVGa0zSr_lST-FHYElQAD82EB2L04QLwBqlgBP-eK4ZKrbcWU52QL4Fe-90",
                    transactionRequest
                ).body() != null
            ) {
                val response = transactionRemoteDataSource.getUserTransactionFromRemote(
                    "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJhdWQiOiIxIiwianRpIjoiOTE3NTYyYzVhN2Q3YzIxYzVhNTgzMTlmMmNhZDA2YzMzYzlhYTZlMmJmMjI0MGI4ODRiNGIwZjdmODUxZGQ1MzQzMzU1YzYyNzYwMDc0MGYiLCJpYXQiOjE2Mjk0ODA4MzgsIm5iZiI6MTYyOTQ4MDgzOCwiZXhwIjoxNjQ1Mzc4NDM4LCJzdWIiOiIyNTYiLCJzY29wZXMiOltdfQ.NcXOPRDEb5Fli2y66V70AOkkmfJZ-DPjsChYW6PopFycl3WDNXvtO62CMjNHDjoUL-RpD7gxBX56U43-89npxVmhkP7bgtGE38HMAk2kawu8eFgKTLQv7XHPUv3xof2ibQ5Usjkmq2l7g5KYZgvYm08MRiRw2JT5EH1oiWwuMiZpBlCf4DBaE5gcdAxA8fh5fg83DGw2Bl3j3xbMjZ8vQiEQXjdPf-ECPcNVuaQgszn94qdAQvS805jUOFGeEzr8_87H7iZvnJ17VhONcL7Ar7N3D1VeOI5rbYLDfets_TKzU0U8tz4ZT3DdEN66pyZ234lkqRZOOeggy61KpCoI3f78vCdnbN7ZQUwE82nn_Rshh_2UdGYHKT_AIX0BTkedGjOFb03HV2UTp2sClaaoR5xr0TypJf1fNOz9-tYgZolerIy0gctvTZYhqsUxs2K-OqeAYzQBQpwKJrT78pc3mW9W9SicTtV9j-kHsHUFImv4ca_AK_yjAyqu81xCgKxFZN1ZvcKIjhtLI5OAqwz-PwtQKPRfr8X3C16NR1d82FohtsSIw1fRfQNsWT4P7Xgs8FhSE-vGSStmnzFwehJcksEo0akfIkkB1YwXOo7b7S3lWgkYbVGa0zSr_lST-FHYElQAD82EB2L04QLwBqlgBP-eK4ZKrbcWU52QL4Fe-90",
                    transactionRequest
                ).body()

                transactions = response!!.transactionList.map {
                    transactionMapper.get()!!.toMapper(it)
                }.toMutableList()
                return transactions
            } else {
                throw IOException("Server is Not Responding")
            }
        } else {
            throw IOException("No Internet Connection")
        }
    }
}