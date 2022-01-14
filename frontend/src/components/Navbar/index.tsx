import { ReactComponent as GithubIcon } from 'assets/img/github.svg';
import './styles.css';

function Navbar() {
    const meus_links = {
        href: "http://www.github.com/wtiinfo",
        target: "_blank"
    };
    return (
        <header>
            <nav className='container'>
                <div className='dsmovie-nav-content'>
                    <h1>DSMovie-Wtiinfo</h1>
                    <a {...meus_links}>
                        <div className='dsmovie-contact-container'>
                            <GithubIcon />
                            <p className='dsmovie-contact-link'>/wtiinfo</p>
                        </div>
                    </a>
                </div>
            </nav>
        </header>
    );
}

export default Navbar;