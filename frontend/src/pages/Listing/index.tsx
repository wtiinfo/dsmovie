import axios from "axios";
import MovieCard from "components/MovieCard";
import Pagination from "components/Pagination";
import { useEffect, useState } from "react";
import { MoviePage } from "types/movie";
import { BASE_URL } from "utils/request";

function Listing() {


    const [pageNumber, setPageNumber] = useState(0);
    const [page, setPage] = useState<MoviePage>({
        content: [],
        last: true,
        totalPages: 0,
        totalElements: 0,
        size: 12,
        number: 0,
        first: true,
        numberOfElements: 0,
        empty: true
    });

    useEffect(() => {
        axios
            .get(`${BASE_URL}/movies?size12&page=${pageNumber}`)
            .then(response => {
                const data = response.data as MoviePage;
                setPage(data);
            });
    }, [pageNumber]);

    const movie = {
        id: 1,
        image: "https://www.themoviedb.org/t/p/w533_and_h300_bestv2/jBJWaqoSCiARWtfV0GlqHrcdidd.jpg",
        title: "The Witcher",
        count: 2,
        score: 4.8
    };

    const handlePageChange = (newPageNumber : number) => {
        setPageNumber(newPageNumber);
    }

    return (
        <>
            <Pagination onChange={handlePageChange} page = {page}/>
            <div className="container">
                <div className="row">
                    {
                        page.content.map(m => (
                            <div className="col-sm-6 col-lg-4 col-xl-3 mb-2" key={m.id}>
                                <MovieCard movie={m} />
                            </div>
                        )
                        )}
                </div>
            </div>
        </>
    );
}

export default Listing;