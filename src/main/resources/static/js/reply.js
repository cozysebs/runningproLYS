async function addReply(replyObj) {
    return $.ajax({
        url: '/replies/',
        type: 'POST',
        contentType: "application/json",
        data:JSON.stringify(replyObj)
    });
}

async function getList({bno, page, size, goLast}){
    console.log("page", page);
    return $.ajax({
        url: `/replies/list/${bno}`,
        type: 'GET',
        data : {page:page, size:size}
    }).then(async  function(response){
        if(goLast){
            const total = response.total;
            const lastPage = parseInt(Math.ceil(total/size));
            return getList({bno:bno, page:lastPage, size:size})
        }
        return response;
    })
}

async function getReply(rno){
    return $.ajax({
        url: `/replies/${rno}`,
        type: 'GET'
    })
}

async function modifyReply(replyObj){
    return $.ajax({
        url: `/replies/${replyObj.rno}`,
        type: 'PUT',
        contentType: "application/json",
        data:JSON.stringify(replyObj)
    });
}

async function removeReply(rno){
    return $.ajax({
        url: `/replies/${rno}`,
        type: 'DELETE'
    })
}
















