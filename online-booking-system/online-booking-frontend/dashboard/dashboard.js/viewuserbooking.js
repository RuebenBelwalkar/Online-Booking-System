function setupTable() {
    const table = document.getElementById('userBookingTable')

    const btnSearch = document.getElementById('btnSearch')
    
    btnSearch.onclick = () =>   {

        apiFetchBooking(table, document.getElementById('txtUsername').value )
    }

    apiFetchAllbookings(table)
}

setupTable()


function propulateActualData(table, userBookings) {

    for(const userBooking of userBookings) {

        const {userId, userName,location, startDate, endDate, startingTime, endingTime, price } = userBooking 
        const viewPageUrl = `./adminviewdetails.html?id=${id}`

        const row = table.insertRow()
        row.insertCell(0).innerHTML = userId
        row.insertCell(1).innerHTML = userName
        row.insertCell(2).innerHTML = location
        row.insertCell(3).innerHTML = startDate
        row.insertCell(4).innerHTML = endDate
        row.insertCell(5).innerHTML = startingTime
        row.insertCell(6).innerHTML = endingTime
        row.insertCell(7).innerHTML = price
        row.insertCell(8).innerHTML = `
            
            <a class='ms-2' href='${viewPageUrl}'>view details</a>  
            
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
        apiCallDeleteBooking(id, modal)
    }
}

function apiFetchAllbookings(table) {
    axios.get('http://localhost:8080/admin/alluserbookings')
        .then(res => {
            const { data } = res
            console.log(data)  
            const { sts, msg, bd } = data

            propulateActualData(table, bd)
        })
        .catch(err => console.log(err))
}

function apiFetchBooking(table, id) {
    const url = `http://localhost:8080/admin/${id}`
    axios.get(url)
        .then(res => {
            const { data } = res
            console.log(data)  
            const { sts, msg, bd } = data

            propulateActualData(table, bd)
        })
        .catch(err => console.log(err))
}


function apiCallDeleteBooking(id, modal) {
    const url = `http://localhost:8080/admin/bookingslot/${id}`

    axios.delete(url)
        .then(res => res.data) // you converted complete response in to our business reponse
        // .then( data => console.log(data.msg) ) // this line can be written in destructured form as below
        .then( ({ sts, msg, bd }) =>  modal.hide() )
        
        .catch(console.log)
}