console.log("review.js loaded");
let modal;

$(document).ready(function () {
    modal = new bootstrap.Modal(document.getElementById('reviewModal'));
    loadReviews();
});


function loadReviews() {
    $.get("http://localhost:8080/api/reviews", function (data) {

        let rows = "";

        data.forEach(r => {
            rows += `
                <tr>
                    <td>${r.id}</td>
                    <td>${r.reviewText}</td>
                    <td>${r.rating}</td>
                    <td>${r.reviewDate}</td>
                    <td>${r.userProfile?.id || ""}</td>
                    <td>${r.movie?.id || ""}</td>
                    <td>
                        <button class="btn btn-warning btn-sm" onclick="editReview(${r.id})">Edit</button>
                        <button class="btn btn-danger btn-sm" onclick="deleteReview(${r.id})">Delete</button>
                    </td>
                </tr>
            `;
        });

        $("#reviewTable").html(rows);
    });
}

function openAddModal() {
    $("#reviewId").val("");
    $("#reviewText").val("");
    $("#rating").val("");
    $("#userId").val("");
    $("#movieId").val("");

    modal.show();
}

function saveReview() {

    let reviewId = $("#reviewId").val().trim();
    // Now just check for empty string
    let isEdit = reviewId !== "";

    let rating = parseInt($("#rating").val());
    if (isNaN(rating) || rating < 1 || rating > 10) {
        alert("Rating must be between 1 and 10");
        return;
    }

    let review = {
        reviewText: $("#reviewText").val(),
        rating: rating,
        reviewDate: new Date().toISOString().split("T")[0],
        userProfile: null,
        movie: null
    };

    let url = isEdit ? `http://localhost:8080/api/reviews/${reviewId}` : `http://localhost:8080/api/reviews`;
    let method = isEdit ? "PUT" : "POST";

    $.ajax({
        url: url,
        type: method,
        contentType: "application/json",
        data: JSON.stringify(review),
        success: function () {
            modal.hide();
            $("#reviewId").val("");  // reset after save too
            loadReviews();
        },
        error: function (xhr) {
            alert("Error: " + xhr.responseText);  // add this to catch silent failures
        }
    });
}

function editReview(id) {
    $.get(`http://localhost:8080/api/reviews/${id}`, function (r) {

        $("#reviewId").val(r.id);
        $("#reviewText").val(r.reviewText);
        $("#rating").val(r.rating);
        $("#userId").val(r.userProfile ? r.userProfile.id : "");
        $("#movieId").val(r.movie ? r.movie.id : "");

        modal.show();
    });
}

function deleteReview(id) {
    if (confirm("Are you sure?")) {
        $.ajax({
            url: `http://localhost:8080/api/reviews/${id}`,
            type: "DELETE",
            success: function () {
                loadReviews();
            }
        });
    }
}

function searchReview() {
    let text = $("#searchText").val();

    $.get(`http://localhost:8080/api/reviews/search?reviewText=${encodeURIComponent(text)}`, function (data) {

        let rows = "";

        data.forEach(r => {
            rows += `
                <tr>
                    <td>${r.id}</td>
                    <td>${r.reviewText}</td>
                    <td>${r.rating}</td>
                    <td>${r.reviewDate}</td>
                    <td>${r.userProfile?.id || ""}</td>
                    <td>${r.movie?.id || ""}</td>
                    <td>
                        <button class="btn btn-warning btn-sm" onclick="editReview(${r.id})">Edit</button>
                        <button class="btn btn-danger btn-sm" onclick="deleteReview(${r.id})">Delete</button>
                    </td>
                </tr>
            `;
        });

        $("#reviewTable").html(rows);
    });
}

    function buildRow(r) {
    return `
                <tr>
                    <td><span class="id-chip">${r.id}</span></td>
                    <td class="review-text-cell" title="${r.reviewText}">${r.reviewText}</td>
                    <td><span class="rating-badge">★ ${r.rating}/10</span></td>
                    <td style="color:var(--text-muted);font-size:0.8rem">${r.reviewDate}</td>
                    <td style="color:var(--text-muted)">${r.userProfile?.id || "—"}</td>
                    <td style="color:var(--text-muted)">${r.movie?.id || "—"}</td>
                    <td>
                        <button class="btn-edit" onclick="editReview(${r.id})">Edit</button>
                        <button class="btn-delete" onclick="deleteReview(${r.id})">Delete</button>
                    </td>
                </tr>
            `;
}

document.querySelectorAll('.nav-links a').forEach(link => {
    if (link.href === window.location.href) {
        link.classList.add('active');
    }
});