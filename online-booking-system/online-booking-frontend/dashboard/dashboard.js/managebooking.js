


function setupTable() {
    const table = document.getElementById('bookingTable')

    const btnSearch = document.getElementById('btnSearch')
    
    btnSearch.onclick = () =>   {

        apiFetchBooking(table, document.getElementById('txtLocation').value )
    }

    apiFetchAllbookings(table)
}

setupTable()


function propulateActualData(table, bookings) {
    while (table.rows.length > 1) {
        table.deleteRow(1)
    }

    for(const booking of bookings) {

        const {id ,location, startDate, endDate, startingTime, endingTime, price } = booking
        const updatePageUrl = `./updatebooking.html?id=${id}`
        const viewPageUrl = `./adminviewbookingdetails.html?id=${id}`

        const row = table.insertRow()
        row.insertCell(0).innerHTML = id
        row.insertCell(1).innerHTML = location
        row.insertCell(2).innerHTML = startDate
        row.insertCell(3).innerHTML = endDate
        row.insertCell(4).innerHTML = startingTime
        row.insertCell(5).innerHTML = endingTime
        row.insertCell(6).innerHTML = price
        row.insertCell(7).innerHTML = `
            <a class='ms-2' href='${updatePageUrl}'>Update</a>
            <a class='ms-2' onclick='showConfirmDeleteModal(${id})'>Delete</a>  
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
    axios.get('http://localhost:8080/admin/bookingslot')
        .then(res => {
            const { data } = res
            console.log(data)  
            const { sts, msg, bd } = data

            propulateActualData(table, bd)
        })
        .catch(err => console.log(err))
}

function apiFetchBooking(table, loc) {
    const url = `http://localhost:8080/admin/filterLocation`
    axios.get(url,{
        params: {
            location: loc
        }
    })
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