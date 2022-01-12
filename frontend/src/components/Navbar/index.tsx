import {ReactComponent as GithubIcon} from 'assets/img/github.svg';

function Navbar() {
    const meus_links = {
        href: "http://www.github.com/wtiinfo",
        target: "_blank"
    };
    return (
        <header>
          <nav>
            <div>
              <h1>DSMovie</h1>
              <a {...meus_links}>
                <div>
                  <GithubIcon />
                  <p>/wtiinfo</p>
                </div>
              </a>
            </div>
          </nav>
        </header>
      );
}
    
export default Navbar;