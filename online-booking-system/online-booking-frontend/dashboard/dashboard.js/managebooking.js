function setupTable() {
    const table = document.getElementById('bookingTable')

    const btnSearch = document.getElementById('btnSearch')
    
    btnSearch.onclick = () =>   {

        apiFetchAllCustomerInvoices(table, document.getElementById('txtClient').value )
    }

    apiFetchAllInvoices(table)
}

setupTable()

// function populateStaticData(table) {
//     for(let i = 0 ; i < 10; i++) {
//         const row = table.insertRow()
//         row.insertCell(0).innerHTML = i + 1
//         row.insertCell(1).innerHTML = 'abc'
//         row.insertCell(2).innerHTML = 2333
//         row.insertCell(3).innerHTML = '2020-01-01'
//         row.insertCell(4).innerHTML = `<a href='#'>View</a> <a class='ms-2' href='#'>Update</a> <a class='ms-2' href='#'>Delete</a> `
//     }
// }

function propulateActualData(table, bookings) {

    for(const booking of bookings) {

        const {id ,location, startDate, endDate, startingTime, endingTime, price, airConditioning, noOFSteps, serviceAvailable } = invoice
        const updatePageUrl = `./update-invoice.html?id=${id}`
        const viewPageUrl = `./view-invoice.html?id=${id}`

        const row = table.insertRow()
        row.insertCell(0).innerHTML = id
        row.insertCell(1).innerHTML = location
        row.insertCell(2).innerHTML = startDate
        row.insertCell(3).innerHTML = endDate
        row.insertCell(4).innerHTML = startingTime
        row.insertCell(5).innerHTML = endingTime
        row.insertCell(6).innerHTML = price
        row.insertCell(7).innerHTML = airConditioning
        row.insertCell(8).innerHTML = noOFSteps
        row.insertCell(9).innerHTML = serviceAvailable
        row.insertCell(10).innerHTML = `
            <a class='ms-2' href='${updatePageUrl}'>Update</a> 
            <a class='ms-2' onclick='showConfirmDeleteModal(${id})'>Delete</a> 
        `
    }
}

function showConfirmDeleteModal(id) {
    console.log('clicked ' + id)
    const myModalEl = document.getElementById('deleteModal');
    const modal = new bootstrap.Modal(myModalEl)
    modal.show()

    const btDl = document.getElementById('btDl')
    btDl.onclick = () => {
        apiCallDeleteInvoice(id, modal)
    }
}

function apiFetchAllbookings(table) {
    axios.get('http://localhost:8080/admin/bookingslot')
        .then(res => {
            const { data } = res
            console.log(data)  
            const { sts, msg, bd } = data

            propulateActualData(table, bd)
        })
        .catch(err => console.log(err))
}

function apiFetchAllCustomerInvoices(table, id) {
    const url = `http://localhost:8080/invoice/customer/${id}`
    axios.get(url)
        .then(res => {
            const { data } = res
            console.log(data)  
            const { sts, msg, bd } = data

            propulateActualData(table, bd)
        })
        .catch(err => console.log(err))
}


function apiCallDeleteInvoice(id, modal) {
    const url = `http://localhost:8080/invoice/${id}`

    axios.delete(url)
        .then(res => res.data) // you converted complete response in to our business reponse
        // .then( data => console.log(data.msg) ) // this line can be written in destructured form as below
        .then( ({ sts, msg, bd }) =>  modal.hide() )
        .catch(console.log)
}